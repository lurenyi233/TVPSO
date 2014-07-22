TVPSO
=====

Introduction
------------
Time Variant PSO (TVPSO) [1] is a refinement of stochastic evolution algorithm Particle Swarm Optimization (PSO) [2]. PSO is mainly used in solving function optimization problems (find the optimal set of a n-dimensional vector subject to an evaluation function).

PSO uses a swarm of particles to simulate birds flocks looking for food. Each particle has a random initial position X and velocity V. The position X is an n-dimensional vector which represents a possible solution to the optimization problem. The objective function (evaluation function) targeted to be optimized is used to evaluate each particle position’s fitness. Higher fitness means a better position. For each particle, PSO uses pbest (persnal best) to record the best position this particle has arrived. For the whole swarm, gbest (global best) is used to record the global best position achieved by all particles. 

Particles' velocity will be updated based on pbest and gbest, and then move to new positions iteratively till all particles converge to the 'optimal' position (the solution of optimization problem).

Updating Methodology
--------------------

References
----------
[1] A. Ratnaweera, S.K. Halgamuge, and H.C. Watson. Self-organizing hierarchical particle swarm optimizer with time-varying acceleration coefficients. IEEE Transactions on Evolutionary Computation, 8(3):240–255, 2004.
[2] J. Kennedy and R. Eberhart. Particle swarm optimization. In Proceedings of IEEE International Conference on Neural Networks, Piscataway, NJ, volume 4, pages 1942–1948. IEEE, 1995.

