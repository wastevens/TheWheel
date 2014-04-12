package com.dsteven.serialization.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class XStreamProvider {

    private static XStream xstream = null;
    
    public XStream getXStream() {
        ensureXStreamExists();
        return xstream;
    }
    
    private void ensureXStreamExists() {
        if (xstream == null) {
            xstream = getForgivingXStreamInstance();
        }
    }

    private XStream getForgivingXStreamInstance() {
        return new XStream(new JettisonMappedXmlDriver()) {
            @Override
            protected MapperWrapper wrapMapper(MapperWrapper next) {
              return new MapperWrapper(next) {
                @SuppressWarnings("rawtypes")
                @Override
                public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                  if (definedIn == Object.class) {
                    return false;
                  }
                  return super.shouldSerializeMember(definedIn, fieldName);
                }
              };
            }
          };
    }
}
