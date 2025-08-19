import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {

    @BeforeEach
    public void setUp() {   // Clear the list before each test

        SeriesModel.seriesList.clear();
    }

    @Test
    public void testAddSeriesDirectly() {
        Series s = new Series("S01", "Breaking Code", "16", "10");
        SeriesModel.seriesList.add(s);

        assertEquals(1, SeriesModel.seriesList.size());
        assertEquals("S01", SeriesModel.seriesList.get(0).getSeriesId());
    }

    @Test
    public void testDeleteExistingSeries() {
        Series s = new Series("S02", "Null Stranger", "13", "8");
        SeriesModel.seriesList.add(s);

        // Simulate deletion manually (since deleteSeries requires Scanner input)
        boolean removed = SeriesModel.seriesList.removeIf(series ->
                series.getSeriesId().equalsIgnoreCase("S02"));

        assertTrue(removed);
        assertEquals(0, SeriesModel.seriesList.size());
    }

    @Test
    public void testDeleteNonExistingSeries() {
        Series s = new Series("S03", "Infinite Loopers", "15", "12");
        SeriesModel.seriesList.add(s);

        boolean removed = SeriesModel.seriesList.removeIf(series ->
                series.getSeriesId().equalsIgnoreCase("WrongID"));

        assertFalse(removed);
        assertEquals(1, SeriesModel.seriesList.size());
    }

    @Test
    public void testMultipleSeriesAdded() {
        Series s1 = new Series("S04", "Series One", "12", "5");
        Series s2 = new Series("S05", "Series Two", "10", "7");
        SeriesModel.seriesList.add(s1);
        SeriesModel.seriesList.add(s2);

        assertEquals(2, SeriesModel.seriesList.size());
        assertEquals("Series One", SeriesModel.seriesList.get(0).getSeriesName());
        assertEquals("Series Two", SeriesModel.seriesList.get(1).getSeriesName());
    }
}
