TVPSO
=====

## Introduction
Time Variant PSO (TVPSO) [1] is a refinement of stochastic evolution algorithm Particle Swarm Optimization (PSO) [2]. PSO is mainly used in solving function optimization problems (find the optimal set of an _n_-dimensional vector subject to an evaluation function).

PSO uses a swarm of particles to simulate birds flocks looking for food. Each particle has a random initial position _**X**_ and velocity _**V**_. The position _**X**_ is an _n_-dimensional vector which represents a possible solution to the optimization problem. The objective function (evaluation function) targeted to be optimized is used to evaluate each particle position’s fitness. Higher fitness means a better position. For each particle, PSO uses _**pbest**_ (persnal best) to record the best position this particle has arrived. For the whole swarm, _**gbest**_ (global best) is used to record the global best position achieved by all particles. 

Particles' velocity will be updated based on _**pbest**_ and _**gbest**_, and then move to new positions iteratively till all particles converge to the 'optimal' position (the solution of optimization problem).

## Updating Methodology
At time _t_, PSO updates each particle’s velocity using the following equation:
>_V<sub>t+1</sub> = wV<sub>t</sub> + c<sub>1</sub>r<sub>1</sub>(pbest − X<sub>t</sub>) + c<sub>2</sub>r<sub>2</sub>(gbest − X<sub>t</sub>)_

where _w_ is the inertia weight, _c<sub>1</sub>_, _c<sub>2</sub>_ are the acceleration coefficients and _r<sub>1</sub>_, _r<sub>2</sub>_ are two random numbers in the range between 0 and 1. After updating the velocity, each particle will move to a new position according to:
>_X<sub>t+1</sub> = X<sub>t</sub> + V<sub>t+1</sub>_

TVPSO also updates _w_, _c<sub>1</sub>_ and _c<sub>2</sub>_ according to the following iterative equations:
>_w<sub>t</sub> = (w<sub>e</sub> - w<sub>b</sub>)t / maxt + w<sub>b</sub>_ <br />
_c<sub>1t</sub> = (c<sub>1e</sub> - c<sub>1b</sub>)t / maxt + c<sub>1b</sub>_ <br />
_c<sub>2t</sub> = (c<sub>2e</sub> - c<sub>2b</sub>)t / maxt + c<sub>2b</sub>_ <br />

where _w<sub>b</sub>_, _w<sub>t</sub>_ and _w<sub>e</sub>_ denote the beginning, current and end value of _w_ respectively (similar for _c<sub>1</sub>_ and _c<sub>2</sub>_), _t_ is the current iteration number and _maxt_ is the maximum number of iterations.

## Usage
**pso.example.Example** gives a simple example of how to use TVPSO for function optimization. More details can be found in codes.

## References
[1] A. Ratnaweera, S.K. Halgamuge, and H.C. Watson. Self-organizing hierarchical particle swarm optimizer with time-varying acceleration coefficients. IEEE Transactions on Evolutionary Computation, 8(3):240–255, 2004.

[2] J. Kennedy and R. Eberhart. Particle swarm optimization. In Proceedings of IEEE International Conference on Neural Networks, Piscataway, NJ, volume 4, pages 1942–1948. IEEE, 1995.

