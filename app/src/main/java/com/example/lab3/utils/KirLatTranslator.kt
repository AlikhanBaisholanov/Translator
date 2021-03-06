package com.example.lab3.utils

import com.afollestad.materialdialogs.MaterialDialog
import com.example.lab3.models.MessageSample
import java.lang.StringBuilder

class KirLatTranslator() {
    private lateinit var slicedWord: CharArray
    private lateinit var materialDialogBuilder: MaterialDialog.Builder
    private lateinit var responseMessage: MessageSample
    private var stringBuilder: StringBuilder = StringBuilder()
    private var receivedWord: String = ""
    private var processedWord: String = ""

    fun kirLatTranslation(text: String): String {
        receivedWord = text
        slicedWord = receivedWord.toCharArray()
        for (i: Int in slicedWord.indices)
            when (slicedWord[i]) {
                'А' -> stringBuilder.append('A')
                'а' -> stringBuilder.append('a')
                'Ә' -> stringBuilder.append('Á')
                'ә' -> stringBuilder.append('á')
                'Б' -> stringBuilder.append('B')
                'б' -> stringBuilder.append('b')
                'В' -> stringBuilder.append('V')
                'в' -> stringBuilder.append('v')
                'Г' -> stringBuilder.append('G')
                'г' -> stringBuilder.append('g')
                'Ғ' -> stringBuilder.append('Ǵ')
                'ғ' -> stringBuilder.append('ǵ')
                'Д' -> stringBuilder.append('D')
                'д' -> stringBuilder.append('d')
                'Е' -> stringBuilder.append('E')
                'е' -> stringBuilder.append('e')
                'Ё' -> stringBuilder.append("Yo")
                'ё' -> stringBuilder.append("yo")
                'Ж' -> stringBuilder.append('J')
                'ж' -> stringBuilder.append('j')
                'З' -> stringBuilder.append('Z')
                'з' -> stringBuilder.append('z')
                'И' -> stringBuilder.append('I')
                'и' -> stringBuilder.append('i')
                'Й' -> stringBuilder.append('I')
                'й' -> stringBuilder.append('i')
                'К' -> stringBuilder.append('K')
                'к' -> stringBuilder.append('k')
                'Қ' -> stringBuilder.append('Q')
                'қ' -> stringBuilder.append('q')
                'Л' -> stringBuilder.append('L')
                'л' -> stringBuilder.append('l')
                'М' -> stringBuilder.append('M')
                'м' -> stringBuilder.append('m')
                'Н' -> stringBuilder.append('N')
                'н' -> stringBuilder.append('n')
                'Ң' -> stringBuilder.append('Ń')
                'ң' -> stringBuilder.append('ń')
                'О' -> stringBuilder.append('O')
                'о' -> stringBuilder.append('o')
                'Ө' -> stringBuilder.append('Ó')
                'ө' -> stringBuilder.append('ó')
                'П' -> stringBuilder.append('P')
                'п' -> stringBuilder.append('p')
                'Р' -> stringBuilder.append('R')
                'р' -> stringBuilder.append('r')
                'С' -> stringBuilder.append('S')
                'с' -> stringBuilder.append('s')
                'Т' -> stringBuilder.append('T')
                'т' -> stringBuilder.append('t')
                'У' -> stringBuilder.append('Ý')
                'у' -> stringBuilder.append('ý')
                'Ұ' -> stringBuilder.append('U')
                'ұ' -> stringBuilder.append('u')
                'Ү' -> stringBuilder.append('Ú')
                'ү' -> stringBuilder.append('ú')
                'Ф' -> stringBuilder.append('F')
                'ф' -> stringBuilder.append('f')
                'Х' -> stringBuilder.append('H')
                'х' -> stringBuilder.append('h')
                'Һ' -> stringBuilder.append('H')
                'һ' -> stringBuilder.append('h')
                'Ц' -> stringBuilder.append("Ts")
                'ц' -> stringBuilder.append("ts")
                'Ч' -> stringBuilder.append("Ch")
                'ч' -> stringBuilder.append("ch")
                'Ш' -> stringBuilder.append("Sh")
                'ш' -> stringBuilder.append("sh")
                'Щ' -> stringBuilder.append("Shch")
                'щ' -> stringBuilder.append("shch")
                'ъ' -> stringBuilder.append('\"')
                'Ы' -> stringBuilder.append('Y')
                'ы' -> stringBuilder.append('y')
                'І' -> stringBuilder.append('I')
                'і' -> stringBuilder.append('i')
                'ь' -> stringBuilder.append('\'')
                'Э' -> stringBuilder.append('E')
                'э' -> stringBuilder.append('e')
                'Ю' -> stringBuilder.append("Yu")
                'ю' -> stringBuilder.append("yu")
                'Я' -> stringBuilder.append("Ya")
                'я' -> stringBuilder.append("ya")
                else -> {
                    stringBuilder.append(slicedWord[i])
                }
            }
        processedWord = stringBuilder.toString()
        stringBuilder.clear()
        return processedWord
    }
}