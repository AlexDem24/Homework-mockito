import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

public class MessageSenderImplTest {

    @Test
    void testSendRussia() {
        final Location location = new Location("Moscow", RUSSIA, "Lenina", 15);
        final Map<String, String> headers = new HashMap<>();
        final String ip = "172.0.32.11";
        final String expected = "Добро пожаловать";

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(location);

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(RUSSIA)).thenReturn(expected);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        assertEquals(expected, messageSender.send(headers));
    }

    @Test
    void testSendUsa() {
        final Location location = new Location("New York", Country.USA, null,  0);
        final Map<String, String> headers = new HashMap<>();
        final String ip = "96.44.183.149";
        final String expected = "Welcome";

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(location);

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(USA)).thenReturn(expected);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        assertEquals(expected, messageSender.send(headers));
    }
}
