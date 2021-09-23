import java.util.List;

class WeatherInfo {
    public Integer now;
    public String now_dt;
    public Info info;
    public Geo_objects geo_object;
    public Yesterfay yesterday;
    public Fact fact;
    public List<DayInfo> forecasts;
}

class Info {
    public Boolean n;
    public Integer geoid;
    public String url;
    public Float lat;
    public Float lon;
    public TZInfo tzinfo;
    public Integer def_pressure_mm;
    public Integer def_pressure_pa;
    public String slug;
    public Integer zoom;
    public Boolean nr;
    public Boolean ns;
    public Boolean nsr;
    public Boolean p;
    public Boolean f;
    public Boolean _h;

}

class TZInfo{
    public String name;
    public String abbr;
    public Boolean dst;
    public Integer offset;
}

class Geo_objects{
    public Geo_source district;
    public Geo_source locality;
    public Geo_source province;
    public Geo_source country;
}

class Geo_source{
    public Integer id;
    public String name;
}

class Yesterfay{
    public Integer temp;
}

class Fact{
    public Integer obs_time;
    public Integer uptime;
    public Integer temp;
    public Integer feels_like;
    public Integer temp_water;
    public String icon;
    public String condition;
    public Float cloudness;
    public Integer prec_type;
    public Integer prec_prob;
    public Integer prec_strength;
    public Boolean is_thunder;
    public Integer wind_speed;
    public String wind_dir;
    public Integer pressure_mm;
    public Integer pressure_pa;
    public Integer humidity;
    public String daytime;
    public Boolean polar;
    public String season;
    public String source;
    public Float soil_moisture;
    public Integer soil_temp;
    public Integer uv_index;
    public Float wind_gust;
}

class DayInfo{
    public String date;
    public Integer date_ts;
    public Integer week;
    public String sunrise;
    public String sunset;
    public String rise_begin;
    public String set_end;
    public Integer moon_code;
    public String moon_text;
    public Parts parts;
    public List<String> hours;
    public Biomet biomet;
}

class Parts{
    public PartInfo night_short;
    public PartInfo day;
    public PartInfo day_short;
    public PartInfo morning;
    public PartInfo evening;
    public PartInfo night;
}

class PartInfo{
    public String _source;
    public Integer temp;
    public Integer temp_water;
    public Float wind_speed;
    public Float wind_gust;
    public String wind_dir;
    public Integer pressure_mm;
    public Integer pressure_pa;
    public Integer humidity;
    public Integer soil_temp;
    public Float soil_moisture;
    public Integer prec_mm;
    public Integer prec_prob;
    public Integer prec_period;
    public Integer cloudness;
    public Integer prec_type;
    public Integer prec_strength;
    public String icon;
    public String condition;
    public Integer uv_index;
    public Integer feels_like;
    public String daytime;
    public Boolean polar;
}

class Biomet{
    public Integer index;
    public String condition;
}