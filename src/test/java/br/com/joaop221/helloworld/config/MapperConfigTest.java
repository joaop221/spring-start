package br.com.joaop221.helloworld.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.convention.MatchingStrategies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class MapperConfigTest {
    @Test
    public void shouldGetMapper() {
        MapperConfig mapper = new MapperConfig();
        assertNotNull("Docket cannot be null!", mapper.getModelMapper());
    }

    @Test
    public void shouldGetMapperWithSTRICT_MatchingStrategies() {
        MapperConfig mapper = new MapperConfig();
        assertEquals("Unexpected Matching Strategy found!",
                mapper.getModelMapper().getConfiguration().getMatchingStrategy(), MatchingStrategies.STRICT);
    }
}
