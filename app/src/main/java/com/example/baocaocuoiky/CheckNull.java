package com.example.baocaocuoiky;

public class CheckNull {                                //Đây là lớp tự xây dựng để kiểm tra dữ liệu nhập vào
    public static boolean isNotNull(String... args){    //String... args là mảng các tham số truyền vào theo kiểu string
        for (String s:                                  //Vòng lặp foreach kiểm tra từng phần tử trong mảng
                args) {
            if(s.equals("")){                           //Nếu có phần tử = "" trả về false vì chúng ta cần tất cả đều không rỗng
                return false;
            }
        }
        return true;                                    //return true vì đã kiểm tra hết các phần tử trong mảng và không có phần tử nào = ""
    }
}
