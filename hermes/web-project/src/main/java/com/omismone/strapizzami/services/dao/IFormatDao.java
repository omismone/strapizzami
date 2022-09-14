package com.omismone.strapizzami.services.dao;

import com.omismone.strapizzami.model.Format;

import java.util.ArrayList;

public interface IFormatDao {
    public ArrayList<Format> getFormats();
    public Boolean insertFormat(Format format);
}
