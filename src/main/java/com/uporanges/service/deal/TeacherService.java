package com.uporanges.service.deal;

import com.uporanges.evo.BackJSON;

public interface TeacherService {

	int checkrole(String user_id);

	BackJSON getteacherself(String user_id);

}
