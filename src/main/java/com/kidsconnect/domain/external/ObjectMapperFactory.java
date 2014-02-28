package com.kidsconnect.domain.external;

/*import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;*/


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.guava.GuavaModule;

public class ObjectMapperFactory
{
    private static boolean indentOutput = true;

    private ObjectMapperFactory()
    {
    }

    public static ObjectMapper newObjectMapper()
    {
/*        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new GuavaModule());
        mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, indentOutput);
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
 */       
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new GuavaModule());
        mapper.configure(SerializationFeature.INDENT_OUTPUT, indentOutput);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);


        return mapper;
    }

    public static void setIndentOutput(boolean indentOutput)
    {
        ObjectMapperFactory.indentOutput = indentOutput;
    }
}
