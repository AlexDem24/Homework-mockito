import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {

    @Test
    void testLocale() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        Assertions.assertEquals("Welcome", localizationService.locale(Country.USA));
    }
}
