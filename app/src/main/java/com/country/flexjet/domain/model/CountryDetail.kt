package ro.alexmamo.roomjetpackcompose.domain.model
import com.country.flexjet.core.Constants.Companion.COUNTRY_DETAILS_TABLE
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = COUNTRY_DETAILS_TABLE)
data class CountryDetail(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val countryName: String,
    val capital: String,
    val population: Int,
    val area: Double,
    val region: String,
    val subRegion: String
)