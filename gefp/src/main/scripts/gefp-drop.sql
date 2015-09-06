
    alter table Cell 
        drop constraint FK_9cihd4a0k4cwgdlk744o7ldou;

    alter table Cell 
        drop constraint FK_s0a37aw4m7ihpmy3us4pdmbl0;

    alter table Cell 
        drop constraint FK_3nhk7mlc8idanh84miu6bb3fa;

    alter table Cell_Checkpoint 
        drop constraint FK_5oss04se5mu8363ctkg4h93sl;

    alter table Cell_Checkpoint 
        drop constraint FK_4dfhliel8fdemmfj96r2g0gru;

    alter table Department 
        drop constraint FK_827cej6gev8bjj786unq4dgbb;

    alter table Department_Plan 
        drop constraint FK_dsd9ryc7apddrp0na45dxi7b1;

    alter table Department_Plan 
        drop constraint FK_kjap1dihj7bg2316l6wj14ofm;

    alter table Plan_Cell 
        drop constraint FK_pbaqg4yr0ww7gwefnm5hskhm;

    alter table Plan_Cell 
        drop constraint FK_furah1b8wqmlemj1xvysyvrep;

    alter table Plan_Runway 
        drop constraint FK_50n0hg68irs69rdk0d3tlhk9n;

    alter table Plan_Runway 
        drop constraint FK_qtvt0olhvdpyg0uhm3rkjfsrc;

    alter table Plan_Stage 
        drop constraint FK_modojlhhcsuh3u4vp4gi2v0yu;

    alter table Plan_Stage 
        drop constraint FK_4r78x1vns0982ni3m4qihbxja;

    alter table Users 
        drop constraint FK_3oaes0r9g8fpx27h8944em387;

    alter table Users 
        drop constraint FK_tepjub63jf9ay1mot9lq4m1fh;

    alter table Users 
        drop constraint FK_t975vg25mg13vova48j1fvqgy;

    alter table Users_Checkpoint 
        drop constraint FK_7uodi7k89l5oxnroul9ii1mo6;

    alter table Users_Checkpoint 
        drop constraint FK_p8jq4yyhhorwfn0nj51igtkxg;

    drop table if exists Cell cascade;

    drop table if exists Cell_Checkpoint cascade;

    drop table if exists Checkpoint cascade;

    drop table if exists Department cascade;

    drop table if exists Department_Plan cascade;

    drop table if exists Plan cascade;

    drop table if exists Plan_Cell cascade;

    drop table if exists Plan_Runway cascade;

    drop table if exists Plan_Stage cascade;

    drop table if exists Runway cascade;

    drop table if exists Stage cascade;

    drop table if exists Users cascade;

    drop table if exists UsersType cascade;

    drop table if exists Users_Checkpoint cascade;

    drop sequence hibernate_sequence;
