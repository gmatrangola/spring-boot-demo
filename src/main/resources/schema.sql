create table if not exists user
(
	id bigint auto_increment
		primary key,
	birthday datetime null,
	enabled bit  default b'1',
	expired_account bit default b'0',
	expired_credentials bit  default b'0',
	first_name varchar(255) null,
	last_name varchar(255) null,
	locked bit  default b'0',
	password varchar(255) null,
	username varchar(255) not null,
	constraint UK_sb8bbouer5wak8vyiiy4pf2bx
		unique (username)
)
engine=MyISAM
;

