algoritmo7 (c[n], …, c[1], L)
	para m ← 1 até n faça
		X[m] ← inf
		k ← m
		s ← c[m]
		enquanto k > 1 e s ≤ L faça
			X’ ← (L − s)³ + X[k−1]
			se X[0] < X[m] então X[m] ← X’
			k ← k − 1
			s ← s + 1 + c[k]
		se s ≤ L então X[m] ← 0
	retorna X[1] 
