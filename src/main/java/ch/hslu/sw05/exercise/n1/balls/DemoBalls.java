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
 * Demonstration von Bällen.
 */
public class DemoBalls {

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) throws InterruptedException {
        final String[] color = {"red", "black", "blue", "yellow", "green", "magenta"};

        var canvas = Canvas.getCanvas();

        for (int i = 0; i < 50; i++) {
            var rand = new Random(i);
            var ball = new Ball(rand.nextInt(20, 50), rand.nextInt(0, 550), rand.nextInt(50), color[rand.nextInt(0, 5)]);
//            new Thread(ball).start();
            Thread.startVirtualThread(ball);
        }
    }
}
