package com.tsu.sdp_mobile_app.admin.data.response

data class FacultyItem(
	val id: String,
	val facName: String,
	val deanName: String,
	val email: String,
	val phone: String,
)

data class ProgrammeItem(
	val id: String,
	val progName: String,
	val progDirName: String,
	val email: String,
	val phone: String,
	val faculty: String,
)

data class GroupItem(
	val id: String,
	val groupName: String,
	val programme: String,
)

data class CourseworkItem(
	val id: String,
	val cwName: String,
	val programme: String,
)