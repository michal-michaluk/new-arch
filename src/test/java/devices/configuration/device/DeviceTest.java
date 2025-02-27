package devices.configuration.device;

import org.junit.jupiter.api.Test;

import static devices.configuration.device.DeviceConfigurationAssert.assertThat;
import static devices.configuration.device.DeviceFixture.*;

class DeviceTest {

    @Test
    void newDeviceHasSettingsSetToDefaults() {
        Device device = Device.newDevice(DeviceFixture.randomId());

        assertThat(device)
                .hasSettings(Settings.defaultSettings());
        //.hasViolationsLikeNotConfiguredDevice();
    }

    @Test
    void overrideSettings() {
        Device device = givenDevice();

        device.updateSettings(settingsForPublicDevice());

        assertThat(device)
                .hasSettings(settingsForPublicDevice());
        //.hasNoViolations();
    }

    @Test
    void updateSingleValueInSettings() {
        Device device = givenDevice();

        device.updateSettings(settingsWithAutoStartOnly());

        assertThat(device)
                .hasSettings(Settings.defaultSettings().toBuilder()
                        .autoStart(true));
        //.hasNoViolations();
    }

    @Test
    void mergeSettings() {
        Device device = givenDevice();

        device.updateSettings(settingsForPublicDevice());
        device.updateSettings(settingsWithAutoStartOnly());

        assertThat(device)
                .hasSettings(Settings.builder()
                        .publicAccess(true)
                        .showOnMap(true)
                        .autoStart(true)
                        .remoteControl(false)
                        .billing(false)
                        .reimbursement(false)
                );
        //.hasNoViolations();
    }

}
