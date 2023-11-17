package com.proven.Data;

import java.io.Serializable;
import java.util.Date;

public class DataClient implements Serializable {
    String name;
    int age;
    String ip;
    int port;
    Date hour;

    public DataClient( String name, int age, String ip, int port, Date hour ) {
        this.name = name;
        this.age = age;
        this.ip = ip;
        this.port = port;
        this.hour = hour;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "DataClient { " );
        sb.append( "name = '" ).append( name ).append( '\'' );
        sb.append( ", age = " ).append( age );
        sb.append( ", ip = '" ).append( ip ).append( '\'' );
        sb.append( ", port = " ).append( port );
        sb.append( ", hour = " ).append( hour.getHours() + ":" + hour.getMinutes() );
        sb.append( " }" );
        return sb.toString();
    }
}
