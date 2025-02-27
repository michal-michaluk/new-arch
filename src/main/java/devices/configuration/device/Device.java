package devices.configuration.device;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
class Device {
    final String deviceId;

    private OpeningHours openingHours;
    private Settings settings;

    public static Device newDevice(String deviceId) {
        return new Device(
                deviceId,
                OpeningHours.alwaysOpened(),
                Settings.defaultSettings()
        );
    }

    void updateOpeningHours(OpeningHours openingHours) {
        openingHours = Objects.requireNonNullElse(openingHours, OpeningHours.alwaysOpened());
        this.openingHours = openingHours;
    }

    void updateSettings(Settings settings) {
        this.settings = this.settings.merge(settings);
    }

    DeviceConfiguration toDeviceConfiguration() {
        return new DeviceConfiguration(
                deviceId,
                openingHours,
                settings
        );
    }
}
