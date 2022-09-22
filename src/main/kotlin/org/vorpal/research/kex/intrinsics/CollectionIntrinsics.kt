package org.vorpal.research.kex.intrinsics

import org.vorpal.research.kex.intrinsics.internal.*

object CollectionIntrinsics {
    /**
     * for all, body takes current index
     * @start -- starting index, inclusive
     * @end -- ending index, exclusive
     */
    @JvmStatic
    fun forAll(start: Int, end: Int, body: IntConsumer): Boolean {
        var result = true
        for (i in start until end) {
            result = body.apply(i)
        }
        return result
    }

    /**
     * generate array, body takes an index generates an element for given index
     * @length -- length of resulting array
     */
    @JvmStatic
    fun generateBoolArray(length: Int, body: BooleanGenerator): BooleanArray {
        val result = BooleanArray(length) { false }
        for (i in 0 until length) {
            result[i] = body.apply(i)
        }
        return result
    }

    @JvmStatic
    fun generateByteArray(length: Int, body: ByteGenerator): ByteArray {
        val result = ByteArray(length) { 0 }
        for (i in 0 until length) {
            result[i] = body.apply(i)
        }
        return result
    }

    @JvmStatic
    fun generateCharArray(length: Int, body: CharGenerator): CharArray {
        val result = CharArray(length) { 0.toChar() }
        for (i in 0 until length) {
            result[i] = body.apply(i)
        }
        return result
    }

    @JvmStatic
    fun generateShortArray(length: Int, body: ShortGenerator): ShortArray {
        val result = ShortArray(length) { 0 }
        for (i in 0 until length) {
            result[i] = body.apply(i)
        }
        return result
    }

    @JvmStatic
    fun generateIntArray(length: Int, body: IntGenerator): IntArray {
        val result = IntArray(length) { 0 }
        for (i in 0 until length) {
            result[i] = body.apply(i)
        }
        return result
    }

    @JvmStatic
    fun generateLongArray(length: Int, body: LongGenerator): LongArray {
        val result = LongArray(length) { 0 }
        for (i in 0 until length) {
            result[i] = body.apply(i)
        }
        return result
    }

    @JvmStatic
    fun generateFloatArray(length: Int, body: FloatGenerator): FloatArray {
        val result = FloatArray(length) { 0.0f }
        for (i in 0 until length) {
            result[i] = body.apply(i)
        }
        return result
    }

    @JvmStatic
    fun generateDoubleArray(length: Int, body: DoubleGenerator): DoubleArray {
        val result = DoubleArray(length) { 0.0 }
        for (i in 0 until length) {
            result[i] = body.apply(i)
        }
        return result
    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    fun <T : Any?> generateObjectArray(length: Int, body: ObjectGenerator<T>): Array<T> {
        val result = Array<Any?>(length) { null }
        for (i in 0 until length) {
            result[i] = body.apply(i)
        }
        return result as Array<T>
    }

    /**
     * contains
     */
    @JvmStatic
    fun containsBool(src: BooleanArray, element: Boolean): Boolean {
        return element in src
    }

    @JvmStatic
    fun containsByte(src: ByteArray, element: Byte): Boolean {
        return element in src
    }

    @JvmStatic
    fun containsChar(src: CharArray, element: Char): Boolean {
        return element in src
    }

    @JvmStatic
    fun containsShort(src: ShortArray, element: Short): Boolean {
        return element in src
    }

    @JvmStatic
    fun containsInt(src: IntArray, element: Int): Boolean {
        return element in src
    }

    @JvmStatic
    fun containsLong(src: LongArray, element: Long): Boolean {
        return element in src
    }

    @JvmStatic
    fun containsFloat(src: FloatArray, element: Float): Boolean {
        return src.any { it == element }
    }

    @JvmStatic
    fun containsDouble(src: DoubleArray, element: Double): Boolean {
        return src.any { it == element }
    }

    @JvmStatic
    fun containsRef(src: Array<Any>, element: Any?): Boolean {
        for (elem in src) {
            if (elem === element) return true
        }
        return false
    }

    @JvmStatic
    fun contains(src: Array<Any>, element: Any?): Boolean {
        return element in src
    }

    @JvmStatic
    fun emptyObjectArray(): Array<Any?> {
        return emptyArray();
    }

    @JvmStatic
    fun arrayCopyAndGrow(src: DoubleArray, growSize: Int): DoubleArray {
        return src.copyOf(src.size + growSize)
    }

    @JvmStatic
    fun arrayCopyAndTrim(src: DoubleArray, trimSize: Int): DoubleArray {
        return src.copyOf(src.size - trimSize)
    }

    @JvmStatic
    fun arrayCopyAndShiftRight(src: DoubleArray, shiftStartIndex: Int, shiftSize: Int): DoubleArray {
        val result = arrayCopyAndGrow(src, shiftSize)
        for (i in shiftStartIndex until src.size) {
            result[i + shiftSize] = src[i]
        }
        return result
    }

    @JvmStatic
    fun arrayCopyAndShiftLeft(src: DoubleArray, shiftStartIndex: Int, shiftSize: Int): DoubleArray {
        val result = arrayCopyAndTrim(src, shiftSize)
        for (i in shiftStartIndex until result.size) {
            result[i] = src[i + shiftSize]
        }
        return result
    }

    @JvmStatic
    fun arrayCopyAndGrow(src: FloatArray, growSize: Int): FloatArray {
        return src.copyOf(src.size + growSize)
    }

    @JvmStatic
    fun arrayCopyAndTrim(src: FloatArray, trimSize: Int): FloatArray {
        return src.copyOf(src.size - trimSize)
    }

    @JvmStatic
    fun arrayCopyAndShiftRight(src: FloatArray, shiftStartIndex: Int, shiftSize: Int): FloatArray {
        val result = arrayCopyAndGrow(src, shiftSize)
        for (i in shiftStartIndex until src.size) {
            result[i + shiftSize] = src[i]
        }
        return result
    }

    @JvmStatic
    fun arrayCopyAndShiftLeft(src: FloatArray, shiftStartIndex: Int, shiftSize: Int): FloatArray {
        val result = arrayCopyAndTrim(src, shiftSize)
        for (i in shiftStartIndex until result.size) {
            result[i] = src[i + shiftSize]
        }
        return result
    }

    @JvmStatic
    fun arrayCopyAndGrow(src: LongArray, growSize: Int): LongArray {
        return src.copyOf(src.size + growSize)
    }

    @JvmStatic
    fun arrayCopyAndTrim(src: LongArray, trimSize: Int): LongArray {
        return src.copyOf(src.size - trimSize)
    }

    @JvmStatic
    fun arrayCopyAndShiftRight(src: LongArray, shiftStartIndex: Int, shiftSize: Int): LongArray {
        val result = arrayCopyAndGrow(src, shiftSize)
        for (i in shiftStartIndex until src.size) {
            result[i + shiftSize] = src[i]
        }
        return result
    }

    @JvmStatic
    fun arrayCopyAndShiftLeft(src: LongArray, shiftStartIndex: Int, shiftSize: Int): LongArray {
        val result = arrayCopyAndTrim(src, shiftSize)
        for (i in shiftStartIndex until result.size) {
            result[i] = src[i + shiftSize]
        }
        return result
    }

    @JvmStatic
    fun arrayCopyAndGrow(src: IntArray, growSize: Int): IntArray {
        return src.copyOf(src.size + growSize)
    }

    @JvmStatic
    fun arrayCopyAndTrim(src: IntArray, trimSize: Int): IntArray {
        return src.copyOf(src.size - trimSize)
    }

    @JvmStatic
    fun arrayCopyAndShiftRight(src: IntArray, shiftStartIndex: Int, shiftSize: Int): IntArray {
        val result = arrayCopyAndGrow(src, shiftSize)
        for (i in shiftStartIndex until src.size) {
            result[i + shiftSize] = src[i]
        }
        return result
    }

    @JvmStatic
    fun arrayCopyAndShiftLeft(src: IntArray, shiftStartIndex: Int, shiftSize: Int): IntArray {
        val result = arrayCopyAndTrim(src, shiftSize)
        for (i in shiftStartIndex until result.size) {
            result[i] = src[i + shiftSize]
        }
        return result
    }

    @JvmStatic
    fun arrayCopyAndGrow(src: ShortArray, growSize: Int): ShortArray {
        return src.copyOf(src.size + growSize)
    }

    @JvmStatic
    fun arrayCopyAndTrim(src: ShortArray, trimSize: Int): ShortArray {
        return src.copyOf(src.size - trimSize)
    }

    @JvmStatic
    fun arrayCopyAndShiftRight(src: ShortArray, shiftStartIndex: Int, shiftSize: Int): ShortArray {
        val result = arrayCopyAndGrow(src, shiftSize)
        for (i in shiftStartIndex until src.size) {
            result[i + shiftSize] = src[i]
        }
        return result
    }

    @JvmStatic
    fun arrayCopyAndShiftLeft(src: ShortArray, shiftStartIndex: Int, shiftSize: Int): ShortArray {
        val result = arrayCopyAndTrim(src, shiftSize)
        for (i in shiftStartIndex until result.size) {
            result[i] = src[i + shiftSize]
        }
        return result
    }

    @JvmStatic
    fun arrayCopyAndGrow(src: CharArray, growSize: Int): CharArray {
        return src.copyOf(src.size + growSize)
    }

    @JvmStatic
    fun arrayCopyAndTrim(src: CharArray, trimSize: Int): CharArray {
        return src.copyOf(src.size - trimSize)
    }

    @JvmStatic
    fun arrayCopyAndShiftRight(src: CharArray, shiftStartIndex: Int, shiftSize: Int): CharArray {
        val result = arrayCopyAndGrow(src, shiftSize)
        for (i in shiftStartIndex until src.size) {
            result[i + shiftSize] = src[i]
        }
        return result
    }

    @JvmStatic
    fun arrayCopyAndShiftLeft(src: CharArray, shiftStartIndex: Int, shiftSize: Int): CharArray {
        val result = arrayCopyAndTrim(src, shiftSize)
        for (i in shiftStartIndex until result.size) {
            result[i] = src[i + shiftSize]
        }
        return result
    }

    @JvmStatic
    fun arrayCopyAndGrow(src: BooleanArray, growSize: Int): BooleanArray {
        return src.copyOf(src.size + growSize)
    }

    @JvmStatic
    fun arrayCopyAndTrim(src: BooleanArray, trimSize: Int): BooleanArray {
        return src.copyOf(src.size - trimSize)
    }

    @JvmStatic
    fun arrayCopyAndShiftRight(src: BooleanArray, shiftStartIndex: Int, shiftSize: Int): BooleanArray {
        val result = arrayCopyAndGrow(src, shiftSize)
        for (i in shiftStartIndex until src.size) {
            result[i + shiftSize] = src[i]
        }
        return result
    }

    @JvmStatic
    fun arrayCopyAndShiftLeft(src: BooleanArray, shiftStartIndex: Int, shiftSize: Int): BooleanArray {
        val result = arrayCopyAndTrim(src, shiftSize)
        for (i in shiftStartIndex until result.size) {
            result[i] = src[i + shiftSize]
        }
        return result
    }

    @JvmStatic
    fun arrayCopyAndGrow(src: ByteArray, growSize: Int): ByteArray {
        return src.copyOf(src.size + growSize)
    }

    @JvmStatic
    fun arrayCopyAndTrim(src: ByteArray, trimSize: Int): ByteArray {
        return src.copyOf(src.size - trimSize)
    }

    @JvmStatic
    fun arrayCopyAndShiftRight(src: ByteArray, shiftStartIndex: Int, shiftSize: Int): ByteArray {
        val result = arrayCopyAndGrow(src, shiftSize)
        for (i in shiftStartIndex until src.size) {
            result[i + shiftSize] = src[i]
        }
        return result
    }

    @JvmStatic
    fun arrayCopyAndShiftLeft(src: ByteArray, shiftStartIndex: Int, shiftSize: Int): ByteArray {
        val result = arrayCopyAndTrim(src, shiftSize)
        for (i in shiftStartIndex until result.size) {
            result[i] = src[i + shiftSize]
        }
        return result
    }

    @JvmStatic
    fun <T> arrayCopyAndGrow(src: Array<T>, growSize: Int): Array<T?> {
        return src.copyOf(src.size + growSize)
    }

    @JvmStatic
    fun <T> arrayCopyAndTrim(src: Array<T>, trimSize: Int): Array<T?> {
        return src.copyOf(src.size - trimSize)
    }

    @JvmStatic
    fun <T> arrayCopyAndShiftRight(src: Array<T>, shiftStartIndex: Int, shiftSize: Int): Array<T?> {
        val result = arrayCopyAndGrow(src, shiftSize)
        for (i in shiftStartIndex until src.size) {
            result[i + shiftSize] = src[i]
        }
        return result
    }

    @JvmStatic
    fun <T> arrayCopyAndShiftLeft(src: Array<T>, shiftStartIndex: Int, shiftSize: Int): Array<T?> {
        val result = arrayCopyAndTrim(src, shiftSize)
        for (i in shiftStartIndex until result.size) {
            result[i] = src[i + shiftSize]
        }
        return result
    }

}
