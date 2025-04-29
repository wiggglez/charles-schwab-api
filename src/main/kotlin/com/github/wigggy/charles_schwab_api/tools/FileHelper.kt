package com.github.wigggy.charles_schwab_api.tools

import java.io.File
import java.io.FileWriter
import java.io.InputStream
import java.nio.charset.Charset

internal object FileHelper {

    fun readFileToString(path: String): String {
        val file = File(path)

        // Read the file line by line
        try {
            val lines = file.readText()
            return lines
        } catch (e: Exception) {
            return "Error reading file: ${e.message}"

        }
    }

    fun writeFile(path: String, txt: String) {
        val file = File(path)

        FileWriter(file).use { writer ->
            writer.write(txt)
        }
    }

    fun loadResourceToString(resourceName: String): String {
        val inputStream: InputStream? = object {}.javaClass.classLoader.getResourceAsStream(resourceName)
        return inputStream!!.bufferedReader(Charset.forName("UTF-8")).use { it.readText() }
    }

}