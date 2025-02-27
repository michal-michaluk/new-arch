package devices.configuration.device;

import org.assertj.core.api.Assertions;

import java.util.Optional;

public class DeviceConfigurationAssert {
    private final DeviceConfiguration device;

    private DeviceConfigurationAssert(DeviceConfiguration device) {
        this.device = device;
    }

    public static DeviceConfigurationAssert assertThat(Device actual) {
        return new DeviceConfigurationAssert(actual.toDeviceConfiguration());
    }

    public static DeviceConfigurationAssert assertThat(DeviceConfiguration actual) {
        return new DeviceConfigurationAssert(actual);
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static DeviceConfigurationAssert assertThat(Optional<DeviceConfiguration> actual) {
        Assertions.assertThat(actual).isNotEmpty();
        return new DeviceConfigurationAssert(actual.get());
    }

    public DeviceConfigurationAssert hasSettings(Settings expected) {
        Assertions.assertThat(device.settings()).isEqualTo(expected);
        return this;
    }

    public DeviceConfigurationAssert hasSettings(Settings.SettingsBuilder expected) {
        Assertions.assertThat(device.settings()).isEqualTo(expected.build());
        return this;
    }


    public DeviceConfigurationAssert hasOpeningHours(OpeningHours expected) {
        Assertions.assertThat(device.openingHours()).isEqualTo(expected);
        return this;
    }

    public DeviceConfigurationAssert hasNoViolations() {
        Assertions.fail("No violations implementation yet");
        return this;
    }

    public DeviceConfigurationAssert hasViolationsLikeNotConfiguredDevice() {
        Assertions.fail("No violations implementation yet");
        return this;
    }
}
