package com.wyl.tms.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wyl.tms.common.DataList;
import com.wyl.tms.common.ExtraResponse;
import com.wyl.tms.dao.FilmInfoMapper;
import com.wyl.tms.model.FilmInfo;
import com.wyl.tms.service.FilmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yhw on 2019-04-22
 */
@Service
public class FilmInfoServiceImpl extends ServiceImpl<FilmInfoMapper, FilmInfo> implements FilmInfoService {
    private final FilmInfoMapper filmInfoMapper;

    @Autowired
    public FilmInfoServiceImpl(FilmInfoMapper filmInfoMapper) {
        this.filmInfoMapper = filmInfoMapper;
    }


    @Override
    public Object getList(Integer pageNo, Integer pageSize, Integer status) {
        Page<FilmInfo> page = new Page<>(pageNo - 1, pageSize);
        List<FilmInfo> filmInfoList = filmInfoMapper.findPage(status, page);
        DataList dataList = new DataList(page.getCurrent(), (int) page.getPages(), page.getSize(), (int) page.getTotal(), filmInfoList);
        return new ExtraResponse(dataList);
    }
}
