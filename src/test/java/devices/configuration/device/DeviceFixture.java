package devices.configuration.device;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class DeviceFixture {

    public static String randomId() {
        return UUID.randomUUID().toString();
    }

    @NotNull
    public static Device givenDevice() {
        return new Device(
                randomId(),
                OpeningHours.alwaysOpened(),
                Settings.defaultSettings()
        );
    }

    @NotNull
    public static DeviceConfiguration givenDeviceConfiguration(String deviceId) {
        return new DeviceConfiguration(
                deviceId,
                OpeningHours.alwaysOpened(),
                Settings.defaultSettings()
        );
    }

    public static Settings settingsWithAutoStartOnly() {
        return Settings.builder()
                .autoStart(true)
                .build();
    }

    public static Settings settingsForPublicDevice() {
        return Settings.defaultSettings().toBuilder()
                .showOnMap(true)
                .publicAccess(true)
                .build();
    }
}
