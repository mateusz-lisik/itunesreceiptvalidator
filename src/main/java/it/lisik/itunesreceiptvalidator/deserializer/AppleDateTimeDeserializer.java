package it.lisik.itunesreceiptvalidator.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.io.IOException;

public class AppleDateTimeDeserializer extends JsonDeserializer<DateTime> {
    private final DateTimeFormatter dateTimeFormatter;

    AppleDateTimeDeserializer() {
        dateTimeFormatter = new DateTimeFormatterBuilder()
                .appendYear(4, 4).appendLiteral('-').appendMonthOfYear(2).appendLiteral('-').appendDayOfMonth(2)
                .appendLiteral(' ')
                .appendHourOfDay(2).appendLiteral(':').appendMinuteOfHour(2).appendLiteral(':').appendSecondOfMinute(2)
                .appendLiteral(' ')
                .appendTimeZoneId().toFormatter();
    }

    @Override
    public DateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        // first try to use standard deserializer;

        try {
            return DateTime.parse(p.getValueAsString());
        } catch (Exception e) {
            return DateTime.parse(p.getValueAsString(), dateTimeFormatter);
        }
    }
}
