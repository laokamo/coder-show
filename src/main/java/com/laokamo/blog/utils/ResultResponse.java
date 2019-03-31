package com.example.blog.utils;

import com.example.blog.vo.ResultVO;

/**
 * @author ：laokamo
 * @date ：Created in 2019-03-29 15:17
 * @description：
 * @version: 1.0.0
 */
public class ResultResponse {

    public static ResultVO success(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVO success(String msg,Object o){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg(msg);
        resultVO.setData(o);
        return resultVO;
    }
}
