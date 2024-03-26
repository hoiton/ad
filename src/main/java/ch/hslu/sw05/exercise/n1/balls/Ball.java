/*
 * Copyright 2024 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.sw05.exercise.n1.balls;

import java.util.Random;

/**
 * Description of class Ball
 */
public class Ball implements Runnable {

    private final Circle circle;
    private final int size;
    private final int offset;

    public Ball(final int size, final int xPos, final int yPos, String color) {
        this.size = size;
        this.circle = new Circle(size, xPos, yPos, color);
        this.offset = new Random().nextInt(1, 4);
    }

    @Override
    public void run() {
        circle.makeVisible();

        while (Canvas.getCanvas().getHeight() > (circle.getY() + size)) {
            circle.moveVertical(offset);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
