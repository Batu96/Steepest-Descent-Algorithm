package com.loony;

public class SteepestDescent {

    //gradient calculation simplified
    double[] calculateGradient(double[] x) {
        double[] g = new double[2];
        g[0] = 2 * x[0] - 2 * x[1];
        g[1] = 2 * x[1] - 2 * x[0];
        return g;
    }

    double gradientMagnitude(double[] x) {
        return Math.sqrt(x[0] * x[0] + x[1] * x[1]);
    }

    void algorithm() {
        // function = (x0-x1)^2 -> x0^2 - 2x0x1 + x1^2
        // gradient = 2x0 - 2x1 , 2x1 - 2x0

        //"epsilon" stopping criterion tolerance
        // "alpha" steep magnitude ( Normally, the alpha parameter can have its own minimization problem but,
        // because I want to focus on the algorithm, I put it simply.)
        double it = 0.0, epsilon = 0.0, alpha = 0.25;
        double[] objectiveFunc = new double[2];
        objectiveFunc[0] = 2;
        objectiveFunc[1] = 1;

//      direction vector
        double[] direction = new double[2];
        double[] g = calculateGradient(objectiveFunc);

        while (gradientMagnitude(g) > epsilon) {
            direction[0] = -g[0];
            direction[1] = -g[1];
            //update objectiveFunc with direction and steep magnitude
            objectiveFunc[0] = objectiveFunc[0] + alpha * direction[0];
            objectiveFunc[1] = objectiveFunc[1] + alpha * direction[1];

            it++;
            g = calculateGradient(objectiveFunc);

        }
        System.out.println("x0: " + objectiveFunc[0] + " x1: " + objectiveFunc[1] + " iteration: "
                + it + " magnitude: " + gradientMagnitude(g));

    }
}
