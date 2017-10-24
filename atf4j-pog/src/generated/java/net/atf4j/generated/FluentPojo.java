// from main/resources/PojoClass.vm
// $timeStamp

package net.atf4j.generated;
import java.util.Date;
public class FluentPojo {
	// ClassField [access=private, type=String, name=string]
	private String string;
	// ClassField [access=private, type=Date, name=date]
	private Date date;
	// ClassField [access=private, type=boolean, name=bool]
	private boolean bool;
	public FluentPojo string(final String string) {
		this.string = string;
		return this;
	}
	public String string() {
		return this.string;
 	}
	public FluentPojo date(final Date date) {
		this.date = date;
		return this;
	}
	public Date date() {
		return this.date;
 	}
	public FluentPojo bool(final boolean bool) {
		this.bool = bool;
		return this;
	}
	public boolean bool() {
		return this.bool;
 	}
}
