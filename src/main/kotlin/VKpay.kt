import kotlin.random.Random

fun main() {
    println("Введите вид карты: Visa, Mastercard, Maestro, VK pay, Мир")
    val typeCard = readLine().toString()
    val sumTranslation = Random.nextInt(0, 700_000 * 60)
    val sumDeal = Random.nextInt(0, 200_000 * 60)
    println("Ваша текущия сумма перевода - " + (sumTranslation / 60) + " рублей и общая сумма за месяц - " + (sumDeal / 60) + " рублей")
    print("Комиссия по переводу составит - ")
    calculateComission(typeCard, sumTranslation, sumDeal)
}

fun calculateComission(
    typeCard: String = "VK pay",
    sumTranslation: Int = 0,
    sumDeal: Int = 0,
): Int {
    while (true)
        if ((typeCard == "Mastercard" || typeCard == "Maestro") && (sumTranslation > 600_000 * 60)) {
            return 600_000 * 60 - sumTranslation
        } else if ((typeCard == "Visa" || typeCard == "Мир") && (sumTranslation > 600_000 * 60)) {
            return 600_000 * 60 - sumTranslation
        } else if (typeCard == "VK pay" && sumTranslation > (40_000 * 60)) {
            return 40_000 * 60 - sumTranslation
        } else if ((typeCard == "Mastercard" || typeCard == "Maestro") && (sumDeal > 150_000 * 60)) {
            return 150_000 * 60 - sumDeal
        } else if ((typeCard == "Visa" || typeCard == "Мир") && (sumDeal > 150_000 * 60)) {
            return 150_000 * 60 - sumDeal
        } else if (typeCard == "VK pay" && sumDeal > (15_000 * 60)) {
            return 15_000 * 60 - sumDeal
        } else {
            print(calculateComission2(typeCard, sumDeal))
            print(" рублей")
        }
}

fun calculateComission2(
    typeCard: String,
    sumDeal: Int
): Number {
    val result = when (typeCard) {
        "Mastercard" -> if (300 * 60 < sumDeal && sumDeal < 75_000 * 60) 0 else (sumDeal / 60 / 100 * 0.6 + 20)
        "Maestro" -> if (300 < sumDeal && sumDeal < 75_000 * 60) 0 else (sumDeal / 60 / 100 * 0.6 + 20)
        "Visa" -> if (sumDeal >= 466_666) 35 else (sumDeal / 60 / 100 * 0.75)
        "Мир" -> if (sumDeal >= 466_666) 35 else (sumDeal / 60 / 100 * 0.75)
        "VK pay" -> 0
        else -> 0
    }
    return result
}
