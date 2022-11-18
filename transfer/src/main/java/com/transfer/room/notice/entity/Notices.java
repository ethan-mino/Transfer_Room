package com.transfer.room.notice.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Notices {

    private int noticeNo;
    private int noticeCritical;
    private int NoticeWriterID;

    private String noticeTitle;
    private String noticeContent;

    private LocalDateTime noticeCreateTime;
    private LocalDateTime noticeUpdateTime;



}
