package br.com.dextra.pointz.models;

import java.util.Calendar;
import java.util.Date;

import io.yawp.repository.IdRef;
import io.yawp.repository.Repository;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;
import io.yawp.repository.annotations.Index;

@Endpoint(path = "/month")
public class Month {

	@Id
	private IdRef<Month> id;

	@Index
	private Integer year;

	@Index
	private Integer month;

	private Long pointz;

	@SuppressWarnings("unused")
	private Month() {
	}

	public Month(Integer year, Integer month) {
		this.year = year;
		this.month = month;
		this.pointz = 0l;
	}

	public void add(Integer pointz) {
		this.pointz += pointz;
	}

	public IdRef<Month> getId() {
		return id;
	}

	public Integer getYear() {
		return year;
	}

	public Integer getMonth() {
		return month;
	}

	public Long getPointz() {
		return pointz;
	}

	public synchronized static void add(Repository yawp, Date date, Integer pointz) {
		Month month = getOrCreateMonth(yawp, date);
		month.add(pointz);
		yawp.save(month);
	}

	private static Month getOrCreateMonth(Repository yawp, Date date) {
		int year, month;
		{
			Calendar c = getCalendar(date);
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH) + 1;
		}

		Month object = yawp.query(Month.class).where("year", "=", year).and("month", "=", month).first();
		if (object == null) {
			object = new Month(year, month);
		}
		return object;
	}

	private static Calendar getCalendar(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}
}
