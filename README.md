TVPSO
=====

## Introduction
Time Variant PSO (TVPSO) [1] is a refinement of stochastic evolution algorithm Particle Swarm Optimization (PSO) [2]. PSO is mainly used in solving function optimization problems (find the optimal set of an n-dimensional vector subject to an evaluation function).

PSO uses a swarm of particles to simulate birds flocks looking for food. Each particle has a random initial position _X_ and velocity _V_. The position _X_ is an n-dimensional vector which represents a possible solution to the optimization problem. The objective function (evaluation function) targeted to be optimized is used to evaluate each particle position’s fitness. Higher fitness means a better position. For each particle, PSO uses _**pbest**_ (persnal best) to record the best position this particle has arrived. For the whole swarm, _**gbest**_ (global best) is used to record the global best position achieved by all particles. 

Particles' velocity will be updated based on pbest and gbest, and then move to new positions iteratively till all particles converge to the 'optimal' position (the solution of optimization problem).

## Updating Methodology
At time _t_, PSO updates each particle’s velocity using the following equation:

_V<sub>t+1</sub> = wV<sub>t</sub> + c<sub>1</sub>r<sub>1</sub>(pbest − X<sub>t</sub>) + c<sub>2</sub>r<sub>2</sub>(gbest − X<sub>t</sub>)_


## References
----------
[1] A. Ratnaweera, S.K. Halgamuge, and H.C. Watson. Self-organizing hierarchical particle swarm optimizer with time-varying acceleration coefficients. IEEE Transactions on Evolutionary Computation, 8(3):240–255, 2004.

[2] J. Kennedy and R. Eberhart. Particle swarm optimization. In Proceedings of IEEE International Conference on Neural Networks, Piscataway, NJ, volume 4, pages 1942–1948. IEEE, 1995.

