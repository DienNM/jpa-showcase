# JPA Hibernate Sample 02

This is showing Mapping Samples in JPA

    - Demo Simple Mapping Type

Type Mapping:
    - JPASampleMapping1Test: Mapping simple type of: byte, int, short, long, boolean, char, float, double 
    - JPASampleMapping2Test: Mapping simple type of : Byte, Integer, Short, Long, Boolean, Character, Float, Double 
    - JPASampleMapping3Test: Mapping simple type of : byte[], Byte[], char[], Character[] 
    - JPASampleMapping4Test: Mapping simple type of : BigInteger, BigDecimal, Date, Calendar, java.sql.Date, Time, Timestamp 

Fetching Mapping: 
    - FetchingMappingTest: 
        + Using @Basic(fetch = LAZY) 
        + Depending on implementation of JPA, (Hibernate is in this case) 
          * Hibernate: implement FieldHandled interface 
        + Lazy field is only loaded as need in persistent status 
