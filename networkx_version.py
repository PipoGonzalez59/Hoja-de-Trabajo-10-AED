import networkx as nx

grafo = nx.DiGraph()

archivo = open("guategrafo.txt", "r")

for linea in archivo:

    datos = linea.split()

    origen = datos[0]
    destino = datos[1]
    distancia = int(datos[2])

    grafo.add_edge(origen, destino, weight=distancia)

archivo.close()

print("Rutas mas cortas:")

rutas = dict(nx.floyd_warshall(grafo))

for ciudad1 in rutas:

    for ciudad2 in rutas[ciudad1]:

        print(ciudad1, "->", ciudad2, "=", rutas[ciudad1][ciudad2])

print("\nCentro del grafo:")

centro = nx.center(grafo)

print(centro)