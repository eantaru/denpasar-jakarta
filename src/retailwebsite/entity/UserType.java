package retailwebsite.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({UserType.EMPLOYEE, UserType.AFFILIATE, UserType.NORMAL})
public @interface UserType {
	int NORMAL = 0;
	int EMPLOYEE = 1;
	int AFFILIATE = 2;
}
