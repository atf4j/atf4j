// from main/resources/templates/FluentPojoClass.vm
// Generated 2017-10-29 15:21.20

package net.atf4j.generated;

import java.util.Date;

public class FluentPojo {

    // String field;
    private String string;

    // Date field;
    private Date date;

    // Boolean field;
    private Boolean bool;

    public FluentPojo() {
        super();
    }

    // ClassField [accessModifier=DEFAULT, visibility=, fieldType=STRING,
    // type=String, name=string, initialValue=null]
    public FluentPojo setString(final String string) {
        this.string = string;
        return this;
    }

    public String getString() {
        return string;
    }

    // ClassField [accessModifier=DEFAULT, visibility=, fieldType=DATE,
    // type=Date, name=date, initialValue=null]
    public FluentPojo setdate(final Date date) {
        this.date = date;
        return this;
    }

    public Date getdate() {
        return date;
    }

    // ClassField [accessModifier=DEFAULT, visibility=, fieldType=BOOLEAN,
    // type=Boolean, name=bool, initialValue=null]
    public FluentPojo setbool(final Boolean bool) {
        this.bool = bool;
        return this;
    }

    public Boolean getbool() {
        return bool;
    }

}
