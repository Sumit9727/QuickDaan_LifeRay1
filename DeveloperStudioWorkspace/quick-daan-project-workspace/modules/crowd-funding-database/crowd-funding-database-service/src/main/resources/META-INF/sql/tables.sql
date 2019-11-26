create table cf_acknowledgement_details (
	uuid_ VARCHAR(75) null,
	ACKNOWLEDGMENT_ID LONG not null primary key,
	PROJECT_ID LONG,
	DETAILS TEXT null,
	DOCUMENT_NAME VARCHAR(75) null,
	DOCUMENT_TYPE VARCHAR(75) null,
	DOCUMENT BLOB,
	VIDEO_TYPE VARCHAR(75) null,
	VIDEO BLOB,
	DATE DATE null
);

create table cf_candidate_details (
	uuid_ VARCHAR(75) null,
	CANDIDATE_ID LONG not null primary key,
	POSITION_ID LONG,
	NAME VARCHAR(75) null,
	EMAIL VARCHAR(75) null,
	MOBILE_NO LONG,
	CURRENT_LOCATION VARCHAR(75) null,
	EXPERIENCE VARCHAR(75) null,
	RESUME_TYPE VARCHAR(75) null,
	RESUME BLOB,
	DATE DATE null,
	STATUS INTEGER
);

create table cf_donor_details (
	uuid_ VARCHAR(75) null,
	DONOR_ID LONG not null primary key,
	NAME VARCHAR(75) null,
	ADDRESS VARCHAR(75) null,
	CITY VARCHAR(75) null,
	STATE VARCHAR(75) null,
	COUNTRY VARCHAR(75) null,
	PINCODE VARCHAR(75) null,
	MAIL_ADDRESS VARCHAR(75) null,
	MOBILE_NO LONG,
	OTP INTEGER,
	MAIL_VERIFICATION INTEGER,
	SMS_VERIFICATION INTEGER,
	CREATION_DATE_TIME DATE null
);

create table cf_dynamic_fees_details (
	uuid_ VARCHAR(75) null,
	CATEGORY_ID LONG not null primary key,
	CATEGORY_NAME VARCHAR(75) null,
	PROCESSING_FEES DOUBLE,
	PROJECT_FEES DOUBLE,
	PAYMENT_GATEWAY_CHARGES DOUBLE,
	OTHER_CHARGES DOUBLE
);

create table cf_extention_details (
	uuid_ VARCHAR(75) null,
	PROJECT_EXTENTION_ID LONG not null primary key,
	PROJECT_ID LONG,
	EXTENTION_DATE DATE null,
	COMMENT VARCHAR(75) null,
	STATUS INTEGER,
	DATE DATE null
);

create table cf_fund_release_details (
	uuid_ VARCHAR(75) null,
	FUND_RELEASE_ID LONG not null primary key,
	PROJECT_FEES_ID LONG,
	PROJECT_ID LONG,
	CURRENCY VARCHAR(75) null,
	PROCESSING_FEES DOUBLE,
	PROJECT_FEES DOUBLE,
	PAYMENT_GATEWAY_CHARGES DOUBLE,
	OTHER_CHARGES DOUBLE,
	TOTAL_WITHDRAW_AMOUNT DOUBLE,
	STATUS INTEGER,
	RELEASE_DATE DATE null,
	REQUEST_DATE DATE null
);

create table cf_history_log_details (
	uuid_ VARCHAR(75) null,
	HISTORY_ID LONG not null primary key,
	USER_ID LONG,
	URL VARCHAR(75) null,
	DATE DATE null
);

create table cf_news_letter_details (
	uuid_ VARCHAR(75) null,
	NEWS_LETTER_ID LONG not null primary key,
	TITLE VARCHAR(75) null,
	DETAILS VARCHAR(75) null,
	DOCUMENT_TYPE VARCHAR(75) null,
	DOCUMENT BLOB,
	DATE DATE null
);

create table cf_position_details (
	uuid_ VARCHAR(75) null,
	POSITION_ID LONG not null primary key,
	ADVERTISMENT_NUM VARCHAR(75) null,
	POSITION_NAME VARCHAR(75) null,
	DESCRIPTION VARCHAR(75) null,
	EXPERIENCE_LEVEL VARCHAR(75) null,
	SALARY VARCHAR(75) null,
	INDUSTRY_TYPE VARCHAR(75) null,
	FUNCTIONAL_AREA VARCHAR(75) null,
	ROLE_CATEGORY VARCHAR(75) null,
	EMPLOYMENT_TYPE VARCHAR(75) null,
	LOCATION VARCHAR(75) null,
	DATE DATE null,
	STATUS INTEGER
);

create table cf_project_account_details (
	uuid_ VARCHAR(75) null,
	ACCOUNT_ID LONG not null primary key,
	PROJECT_ID LONG,
	ACCOUNT_NO LONG,
	ACCOUNT_HOLDER_NAME VARCHAR(1000) null,
	IFSC_CODE VARCHAR(75) null,
	UPI_NO VARCHAR(75) null
);

create table cf_project_benificiary_details (
	uuid_ VARCHAR(75) null,
	BENIFICIARY_ID LONG not null primary key,
	BENIFICIARY_CATEGORY VARCHAR(75) null,
	BENIFICIARY_TYPE VARCHAR(75) null,
	BENIFICIARY_NAME VARCHAR(500) null,
	AGE VARCHAR(75) null,
	GENDER VARCHAR(75) null,
	LOCATION VARCHAR(75) null,
	RELATIONSHIP VARCHAR(500) null,
	RELATIONSHIP_DETAILS VARCHAR(75) null,
	MEMBERS_NO INTEGER,
	CAUSE_DETAILS VARCHAR(75) null,
	ADDRESS_LINE1 VARCHAR(1000) null,
	ADDRESS_LINE2 VARCHAR(1000) null,
	CITY VARCHAR(75) null,
	STATE VARCHAR(75) null,
	PINCODE INTEGER,
	COUNTRY VARCHAR(75) null,
	CONTACT_NAME VARCHAR(75) null,
	CONTACT_NO LONG,
	ALTERNATE_CONTACT_NO LONG,
	EMERGENCY_CONTACT_DETAILS TEXT null,
	IMAGE_TYPE VARCHAR(75) null,
	IMAGE BLOB
);

create table cf_project_comment_details (
	uuid_ VARCHAR(75) null,
	PROJECT_COMMENT_ID LONG not null primary key,
	PROJECT_ID LONG,
	COMMENT TEXT null,
	ANSWER TEXT null,
	DONOR_USER_ID LONG,
	COMMENT_DATE DATE null,
	STATUS INTEGER
);

create table cf_project_document_details (
	uuid_ VARCHAR(75) null,
	PROJECT_DOCUMENT_ID LONG not null primary key,
	PROJECT_ID LONG,
	DOCUMENT_NAME VARCHAR(1000) null,
	DOCUMENT_TYPE VARCHAR(75) null,
	DOCUMENT BLOB
);

create table cf_project_feedback_details (
	uuid_ VARCHAR(75) null,
	PROJECT_FEEDBACK_ID LONG not null primary key,
	PROJECT_ID LONG,
	FEEDBACK TEXT null,
	DONOR_USER_ID LONG,
	FEEDBACK_DATE DATE null,
	STATUS INTEGER
);

create table cf_project_fees_details (
	uuid_ VARCHAR(75) null,
	PROJECT_FEES_ID LONG not null primary key,
	CATEGORY_ID LONG,
	PROJECT_ID LONG,
	START_AMOUNT DOUBLE,
	END_AMOUNT DOUBLE,
	WITHDRAW_STATUS INTEGER,
	DATE DATE null
);

create table cf_project_follower_details (
	uuid_ VARCHAR(75) null,
	PROJECT_FOLLOWER_ID LONG not null primary key,
	USER_ID LONG,
	PROJECT_ID LONG,
	STATUS INTEGER
);

create table cf_project_fund_details (
	uuid_ VARCHAR(75) null,
	PROJECT_FUND_ID LONG not null primary key,
	DONOR_ID LONG,
	PROJECT_ID LONG,
	CATEGORY_ID LONG,
	CURRENCY VARCHAR(75) null,
	DONATED_AMOUNT DOUBLE,
	DONOR_USER_ID LONG,
	DONOR_STATUS INTEGER,
	COMMENT TEXT null,
	DONATED_DATE DATE null
);

create table cf_project_image_details (
	uuid_ VARCHAR(75) null,
	PROJECT_IMAGE_ID LONG not null primary key,
	PROJECT_ID LONG,
	IMAGE_NAME VARCHAR(75) null,
	IMAGE_TYPE VARCHAR(75) null,
	IMAGE BLOB
);

create table cf_project_master (
	uuid_ VARCHAR(75) null,
	PROJECT_ID LONG not null primary key,
	USER_ID LONG,
	BENIFICIARY_ID LONG,
	TITLE TEXT null,
	DESCRIPTION TEXT null,
	VIDEO_TYPE VARCHAR(75) null,
	VIDEO BLOB,
	REQUIRED_FUND_AMOUNT DOUBLE,
	CREATION_DATE DATE null,
	END_DATE DATE null,
	COMMENT VARCHAR(75) null,
	STATUS INTEGER,
	REQUEST_STATUS INTEGER
);

create table cf_project_priority_details (
	uuid_ VARCHAR(75) null,
	PROJECT_PRIORITY_ID LONG not null primary key,
	PROJECT_ID LONG,
	PRIORITY INTEGER,
	PRIORITY_SEQUANCE INTEGER
);

create table cf_project_question_details (
	uuid_ VARCHAR(75) null,
	PROJECT_QUESTION_ID LONG not null primary key,
	PROJECT_ID LONG,
	QUESTION TEXT null,
	QUESTION_REQUESTER_USER_ID LONG,
	QUESTION_DATE DATE null,
	STATUS INTEGER
);

create table cf_project_update_details (
	uuid_ VARCHAR(75) null,
	PROJECT_UPDATE_ID LONG not null primary key,
	PROJECT_ID LONG,
	UPDATE_DETAILS TEXT null,
	UPDATE_DATE DATE null,
	STATUS INTEGER
);

create table cf_subscription_details (
	uuid_ VARCHAR(75) null,
	SUSCRIBER_ID LONG not null primary key,
	EMAIL VARCHAR(75) null,
	STATUS INTEGER
);

create table cf_update_requester_details (
	uuid_ VARCHAR(75) null,
	PROJECT_UPDATE_REQUEST_ID LONG not null primary key,
	PROJECT_ID LONG,
	UPDATE_REQUESTER_USER_ID LONG,
	UPDATE_REQUEST_DATE DATE null,
	STATUS INTEGER
);

create table cf_user_follow_details (
	uuid_ VARCHAR(75) null,
	USER_FOLLOW_ID LONG not null primary key,
	USER_ID LONG,
	FOLLOWER_USER_ID LONG,
	STATUS INTEGER
);

create table cf_user_master (
	uuid_ VARCHAR(75) null,
	USER_ID LONG not null primary key,
	USER_OTP_ID LONG,
	FULL_NAME VARCHAR(1000) null,
	PASSWORD VARCHAR(75) null,
	GENDER VARCHAR(75) null,
	CREATION_DATE DATE null
);


create table cf_user_otp_details (
	uuid_ VARCHAR(75) null,
	USER_OTP_ID LONG not null primary key,
	MOBILE_NO LONG,
	MAIL VARCHAR(75) null,
	OTP INTEGER,
	OTP_DEVICE INTEGER,
	OTP_VERIFICATION_STATUS INTEGER,
	CREATION_DATE_TIME DATE null
);