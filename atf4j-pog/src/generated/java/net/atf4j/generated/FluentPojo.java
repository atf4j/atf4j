// from main/resources/templates/FluentPojoClass.vm
// Generated 2017-10-28 10:11.30

package net.atf4j.generated;

import java.util.Date;

public class FluentPojo {

	//  String string;
	private String string;
	//  Date date;
	private Date date;
	//  Boolean bool;
	private Boolean bool;

	public FluentPojo() {
		super();
	}

	// ClassField [accessModifier=DEFAULT, visibility=, fieldType=STRING, type=String, name=string, initialValue=null]
	public FluentPojo setstring(final String string) {
		this.string = string;
		return this;
	}

	public String getstring() {	
		return this.string;
 	}
	// ClassField [accessModifier=DEFAULT, visibility=, fieldType=DATE, type=Date, name=date, initialValue=null]
	public FluentPojo setdate(final Date date) {
		this.date = date;
		return this;
	}

	public Date getdate() {	
		return this.date;
 	}
	// ClassField [accessModifier=DEFAULT, visibility=, fieldType=BOOLEAN, type=Boolean, name=bool, initialValue=null]
	public FluentPojo setbool(final Boolean bool) {
		this.bool = bool;
		return this;
	}

	public Boolean getbool() {	
		return this.bool;
 	}

}
