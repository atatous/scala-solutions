package com.htes.tree.TrieNode

object TrieNodeSample {
  case class TrieNode(children: Map[Char, TrieNode] = Map.empty, isEndOfWord: Boolean = false) {

    // 1. INSERTION
    // Tail-recursive helper to walk down the word, creating nodes as needed
    def insert(word: String): TrieNode = {
      def loop(chars: List[Char], node: TrieNode): TrieNode = chars match {
        case Nil =>
          node.copy(isEndOfWord = true)
        case head :: tail =>
          val childNode = node.children.getOrElse(head, TrieNode())
          val updatedChild = loop(tail, childNode)
          node.copy(children = node.children + (head -> updatedChild))
      }

      loop(word.toList, this)
    }

    // 2. SEARCH (Exact Match)
    def search(word: String): Boolean = {
      def loop(chars: List[Char], node: TrieNode): Boolean = chars match {
        case Nil => node.isEndOfWord
        case head :: tail =>
          node.children.get(head) match {
            case Some(nextNode) => loop(tail, nextNode)
            case None => false // Path broken, word doesn't exist
          }
      }

      loop(word.toList, this)
    }

    // 3. PREFIX SEARCH (Starts With)
    def startsWith(prefix: String): Boolean = {
      def loop(chars: List[Char], node: TrieNode): Boolean = chars match {
        case Nil => true // Reached the end of prefix successfully
        case head :: tail =>
          node.children.get(head) match { 
            case Some(nextNode) => loop(tail, nextNode)
            case None => false
          }
      }

      loop(prefix.toList, this)
    }
  }

}
