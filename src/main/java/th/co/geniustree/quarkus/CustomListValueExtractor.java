package th.co.geniustree.quarkus;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

import java.util.List;

@ApplicationScoped
public class CustomListValueExtractor implements ValueExtractor<List<@ExtractedValue ?>> {
@Override
public void extractValues(List<?> originalValue, ValueExtractor.ValueReceiver receiver) {
    for ( int i = 0; i < originalValue.size(); i++ ) {
        // not passing the node name, so it won't appear in the path
        receiver.indexedValue( null, i, originalValue.get( i ) );
    }
}
}