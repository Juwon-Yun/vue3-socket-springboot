package com.example.vue.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocketVO {
    private String id;
    private String text;
    private String date;
    private String alarm;
    private String textAreaText;
}
