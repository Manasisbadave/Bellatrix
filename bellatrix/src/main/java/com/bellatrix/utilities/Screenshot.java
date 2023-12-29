package com.bellatrix.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.bellatrix.base.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshot {
	public void captureFullPageScreenshot(String fileName) throws IOException {

		AShot ashot = new AShot();
		BufferedImage img = ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000))
				.takeScreenshot(TestBase.getDriver()).getImage();

		String baseDir = System.getProperty("user.dir");
		File file = new File(baseDir + "/src/test/resources/failedtestcases/" + fileName + "failed.png");
		ImageIO.write(img, "png", file);
	}
}
