package com.example.testexam01

import java.util.*

class Edge(val source: Int, val destination: Int, val weight: Int)

class Graph(private val vertices: Int) {
    private val adjacencyList: MutableList<MutableList<Edge>> = MutableList(vertices) { mutableListOf() }

    fun addEdge(source: Int, destination: Int, weight: Int) {
        val edge = Edge(source, destination, weight)
        adjacencyList[source].add(edge)
        adjacencyList[destination].add(edge)
    }

    fun primMST(): List<Edge> {
        val mst: MutableList<Edge> = mutableListOf()
        val minHeap = PriorityQueue<Edge>(compareBy { it.weight })
        val visited = BooleanArray(vertices)

        // 임의의 시작 정점을 선택
        val startVertex = 0
        visited[startVertex] = true

        // 시작 정점과 연결된 간선을 힙에 추가
        adjacencyList[startVertex].forEach { edge ->
            minHeap.add(edge)
        }

        println("Selected Node: $startVertex")

        // MST를 구성하기 위해 간선 선택 반복
        while (minHeap.isNotEmpty()) {
            val edge = minHeap.remove()

            val sourceVisited = visited[edge.source]
            val destinationVisited = visited[edge.destination]

            // 싸이클을 형성하지 않는 간선 선택
            if (sourceVisited && destinationVisited) {
                continue
            }

            // 현재 간선을 MST에 추가
            mst.add(edge)

            // 현재 정점을 방문 처리
            if (!sourceVisited) {
                visited[edge.source] = true

                // 현재 정점과 연결된 간선을 힙에 추가
                adjacencyList[edge.source].forEach { connectedEdge ->
                    if (!visited[connectedEdge.destination]) {
                        minHeap.add(connectedEdge)
                    }
                }

                println("Selected Node: ${edge.source}")
            }

            if (!destinationVisited) {
                visited[edge.destination] = true

                // 현재 정점과 연결된 간선을 힙에 추가
                adjacencyList[edge.destination].forEach { connectedEdge ->
                    if (!visited[connectedEdge.destination]) {
                        minHeap.add(connectedEdge)
                    }
                }

                println("Selected Node: ${edge.destination}")
            }
        }

        return mst
    }
}

fun main() {
    val graph = Graph(5)
    graph.addEdge(0, 1, 2)
    graph.addEdge(0, 3, 6)
    graph.addEdge(1, 2, 3)
    graph.addEdge(1, 3, 8)
    graph.addEdge(1, 4, 5)
    graph.addEdge(2, 4, 7)
    graph.addEdge(3, 4, 9)

    val mst = graph.primMST()

    println("Minimum Spanning Tree:")
    for (edge in mst) {
        println("${edge.source} -- ${edge.destination} : ${edge.weight}")
    }
}
