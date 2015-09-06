
    create table Cell (
        id int8 not null,
        plan_id int8,
        runway_id int8,
        stage_id int8,
        primary key (id)
    );

    create table Cell_Checkpoint (
        Cell_id int8 not null,
        checkpoints_id int8 not null
    );

    create table Checkpoint (
        id int8 not null,
        description varchar(255),
        primary key (id)
    );

    create table Department (
        id int8 not null,
        name varchar(255),
        currentplan_id int8,
        primary key (id)
    );

    create table Department_Plan (
        Department_id int8 not null,
        plans_id int8 not null
    );

    create table Plan (
        id int8 not null,
        name varchar(255),
        publishedDate date,
        primary key (id)
    );

    create table Plan_Cell (
        Plan_id int8 not null,
        cells_id int8 not null,
        primary key (Plan_id, cells_id)
    );

    create table Plan_Runway (
        Plan_id int8 not null,
        runways_id int8 not null
    );

    create table Plan_Stage (
        Plan_id int8 not null,
        stages_id int8 not null
    );

    create table Runway (
        id int8 not null,
        name varchar(255),
        primary key (id)
    );

    create table Stage (
        id int8 not null,
        name varchar(255),
        primary key (id)
    );

    create table Users (
        id int8 not null,
        enabled boolean not null,
        password varchar(255),
        username varchar(255),
        major_id int8,
        plan_id int8,
        userrole_UserTypeId int4,
        primary key (id)
    );

    create table UsersType (
        UserTypeId int4 not null,
        Type varchar(255),
        primary key (UserTypeId)
    );

    create table Users_Checkpoint (
        user_id int8 not null,
        checkpoints_id int8 not null,
        primary key (user_id, checkpoints_id)
    );

    alter table Cell_Checkpoint 
        add constraint UK_5oss04se5mu8363ctkg4h93sl unique (checkpoints_id);

    alter table Department_Plan 
        add constraint UK_dsd9ryc7apddrp0na45dxi7b1 unique (plans_id);

    alter table Plan_Cell 
        add constraint UK_pbaqg4yr0ww7gwefnm5hskhm unique (cells_id);

    alter table Plan_Runway 
        add constraint UK_50n0hg68irs69rdk0d3tlhk9n unique (runways_id);

    alter table Plan_Stage 
        add constraint UK_modojlhhcsuh3u4vp4gi2v0yu unique (stages_id);

    alter table Cell 
        add constraint FK_9cihd4a0k4cwgdlk744o7ldou 
        foreign key (plan_id) 
        references Plan;

    alter table Cell 
        add constraint FK_s0a37aw4m7ihpmy3us4pdmbl0 
        foreign key (runway_id) 
        references Runway;

    alter table Cell 
        add constraint FK_3nhk7mlc8idanh84miu6bb3fa 
        foreign key (stage_id) 
        references Stage;

    alter table Cell_Checkpoint 
        add constraint FK_5oss04se5mu8363ctkg4h93sl 
        foreign key (checkpoints_id) 
        references Checkpoint;

    alter table Cell_Checkpoint 
        add constraint FK_4dfhliel8fdemmfj96r2g0gru 
        foreign key (Cell_id) 
        references Cell;

    alter table Department 
        add constraint FK_827cej6gev8bjj786unq4dgbb 
        foreign key (currentplan_id) 
        references Plan;

    alter table Department_Plan 
        add constraint FK_dsd9ryc7apddrp0na45dxi7b1 
        foreign key (plans_id) 
        references Plan;

    alter table Department_Plan 
        add constraint FK_kjap1dihj7bg2316l6wj14ofm 
        foreign key (Department_id) 
        references Department;

    alter table Plan_Cell 
        add constraint FK_pbaqg4yr0ww7gwefnm5hskhm 
        foreign key (cells_id) 
        references Cell;

    alter table Plan_Cell 
        add constraint FK_furah1b8wqmlemj1xvysyvrep 
        foreign key (Plan_id) 
        references Plan;

    alter table Plan_Runway 
        add constraint FK_50n0hg68irs69rdk0d3tlhk9n 
        foreign key (runways_id) 
        references Runway;

    alter table Plan_Runway 
        add constraint FK_qtvt0olhvdpyg0uhm3rkjfsrc 
        foreign key (Plan_id) 
        references Plan;

    alter table Plan_Stage 
        add constraint FK_modojlhhcsuh3u4vp4gi2v0yu 
        foreign key (stages_id) 
        references Stage;

    alter table Plan_Stage 
        add constraint FK_4r78x1vns0982ni3m4qihbxja 
        foreign key (Plan_id) 
        references Plan;

    alter table Users 
        add constraint FK_3oaes0r9g8fpx27h8944em387 
        foreign key (major_id) 
        references Department;

    alter table Users 
        add constraint FK_tepjub63jf9ay1mot9lq4m1fh 
        foreign key (plan_id) 
        references Plan;

    alter table Users 
        add constraint FK_t975vg25mg13vova48j1fvqgy 
        foreign key (userrole_UserTypeId) 
        references UsersType;

    alter table Users_Checkpoint 
        add constraint FK_7uodi7k89l5oxnroul9ii1mo6 
        foreign key (checkpoints_id) 
        references Checkpoint;

    alter table Users_Checkpoint 
        add constraint FK_p8jq4yyhhorwfn0nj51igtkxg 
        foreign key (user_id) 
        references Users;

    create sequence hibernate_sequence;
