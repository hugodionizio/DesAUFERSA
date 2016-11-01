algoritmo8 (n, p, c, v)
	para b  ← 0 até c faça
		X[0, b] ← 0
		para j ← 1 até n faça
			x ← X[j − 1, b]
			se b − p[j] ≥ 0
				então y ← X[j − 1, b − p[j]] + v[j]
					se x < y então x ← y
			X[j, b] ← x
	retorna X[n, c]
