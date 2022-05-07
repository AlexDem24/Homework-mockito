import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {

    @Test
    void testByIp() {
        GeoService geoService = new GeoServiceImpl();
        Assertions.assertEquals(Country.RUSSIA, geoService.byIp("172.").getCountry());

    }
}
