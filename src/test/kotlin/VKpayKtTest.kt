import org.junit.Test

import org.junit.Assert.*

class VKpayKtTest {

    @Test
    fun calculateComission_Test1_ExceededTheLimitInTheMonth_VK() {
        val typeCard: String = "VK pay"
        val sumTranslation: Int = 50_000 * 60
        val sumDeal: Int = 0
        val result = calculateComission(
            typeCard,
            sumTranslation,
            sumDeal,
        )
        assertEquals(-600_000, result)
    }

    @Test
    fun calculateComission_Test2_ExceededTheLimitInDay_VK() {
        val typeCard: String = "VK pay"
        val sumTranslation: Int = 0
        val sumDeal: Int = 300_000 * 60
        val result = calculateComission(
            typeCard,
            sumTranslation,
            sumDeal,
        )
        assertEquals(-17_000_000, result)
    }

    @Test
    fun calculateComission_Test3_ExceededTheLimitInMonth_Maestro() {
        val typeCard: String = "Maestro"
        val sumTranslation: Int = 1_000_000 * 60
        val sumDeal: Int = 0
        val result = calculateComission(
            typeCard,
            sumTranslation,
            sumDeal,
        )
        assertEquals(-24_000_000, result)
    }

    @Test
    fun calculateComission_Test4_ExceededTheLimitInDay_Visa() {
        val typeCard: String = "Visa"
        val sumTranslation: Int = 0
        val sumDeal: Int = 153_123 * 60
        val result = calculateComission(
            typeCard,
            sumTranslation,
            sumDeal,
        )
        assertEquals(-187_380, result)
    }

    @Test
    fun calculateComission_Test5_ExceededTheLimitInMonth_Mastercard() {
        val typeCard: String = "Mastercard"
        val sumTranslation: Int = 1_123_123 * 60
        val sumDeal: Int = 0
        val result = calculateComission(
            typeCard,
            sumTranslation,
            sumDeal,
        )
        assertEquals(-31_387_380, result)
    }
    fun calculateComission_Test6_ExceededTheLimitInDay_Mastercard() {
        val typeCard: String = "Mastercard"
        val sumTranslation: Int = 0
        val sumDeal: Int = 153_123 * 60
        val result = calculateComission(
            typeCard,
            sumTranslation,
            sumDeal,
        )
        assertEquals(-187_380, result)
    }
    @Test
    fun calculateComission_Test7_ExceededTheLimitInDay_Mir() {
        val typeCard: String = "Мир"
        val sumTranslation: Int = 600_001 * 60
        val sumDeal: Int = 0
        val result = calculateComission(
            typeCard,
            sumTranslation,
            sumDeal,
        )
        assertEquals(-40, result)
    }

    @Test
    fun calculateComission2_Test1_ComissionForVk() {
        val typeCard: String = "VK pay"
        val sumDeal: Int = 865_000
        val result = calculateComission2(
            typeCard, sumDeal
        )
        assertEquals(0, result)
    }
    @Test
    fun calculateComission2_Test2_ComissionForMastercard() {
        val typeCard: String = "Mastercard"
        val sumDeal: Int = 80_000 * 60
        val result = calculateComission2(
            typeCard, sumDeal
        )
        assertEquals(500.0, result)
    }
    @Test
    fun calculateComission2_Test3_ComissionForMaestro() {
        val typeCard: String = "Maestro"
        val sumDeal: Int = 111_111 * 60
        val result = calculateComission2(
            typeCard, sumDeal
        )
        assertEquals( 686.6, result)
    }
    @Test
    fun calculateComission2_Test4_ComissionForVisa() {
        val typeCard: String = "Visa"
        val sumDeal: Int = 555_555
        val result = calculateComission2(
            typeCard, sumDeal
        )
        assertEquals( 35, result)
    }
    @Test
    fun calculateComission2_Test5_ComissionForMir() {
        val typeCard: String = "Мир"
        val sumDeal: Int = 180
        val result = calculateComission2(
            typeCard, sumDeal
        )
        assertEquals( 0.0, result)
    }
    @Test
    fun calculateComission2_Test5_ComissionFor0() {
        val typeCard: String = " "
        val sumDeal: Int = 555_555_897
        val result = calculateComission2(
            typeCard, sumDeal
        )
        assertEquals( 0, result)
    }
}