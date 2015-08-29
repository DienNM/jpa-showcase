# JPA Hibernate Sample 02

This is showing Mapping Samples in JPA

    - Demo Simple Mapping Type

Type Mapping:

    - JPASampleMapping1Test: Mapping simple type of: byte, int, short, long, boolean, char, float, double
    - JPASampleMapping2Test: Mapping simple type of : Byte, Integer, Short, Long, Boolean, Character, Float, Double 
    - JPASampleMapping3Test: Mapping simple type of : byte[], Byte[], char[], Character[] 
    - JPASampleMapping4Test: Mapping simple type of : BigInteger, BigDecimal, Date, Calendar, java.sql.Date, Time, Timestamp
        + For java.util types, using @Temporal to specific JDBC type as a value of TemporalType

Fetching Mapping: 

    - FetchingMappingTest: 
        + Using @Basic(fetch = LAZY) 
        + Depending on implementation of JPA, (Hibernate is in this case) 
          * Hibernate: implement FieldHandled interface 
        + Lazy field is only loaded as need in persistent status 
        
Large Object Mapping:

    - LargeObjectMappingTest 
    - @Lob
    - LOBs come in two kinds in the database:
        + Binary Large Ojbects, calls BLOBs
            * Java Type Mapping: byte[], Byte[], Serializable
        + Character Large Objects, calls CLOBs
            * Java Type Mapping: char[], Character[], String objects
            
Enumeration Mapping:

    - EnumerationMappingModel
    - Using @Enumerated(EnumType.STRING) - to store NAME
    - Using @Enumerated(EnumType.ORDINAL) to store ordinal. This type is by default
    
Identifier

    - IdentifierTest
