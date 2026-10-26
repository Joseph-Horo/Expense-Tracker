package com.example.core.ui.icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("CheckReturnValue")
public val MoneyBagFill: ImageVector
  get() {
    if (_MoneyBagFill != null) {
      return _MoneyBagFill!!
    }
    _MoneyBagFill =
      ImageVector.Builder(
          name = "MoneyBagFill",
          defaultWidth = 24.dp,
          defaultHeight = 24.dp,
          viewportWidth = 24f,
          viewportHeight = 24f,
        )
        .apply {
          path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1f,
            stroke = null,
            strokeAlpha = 1f,
            strokeLineWidth = 1f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Bevel,
            strokeLineMiter = 1f,
            pathFillType = PathFillType.NonZero,
          ) {
            moveTo(12f, 16f)
            quadToRelative(-0.82f, 0f, -1.41f, -0.59f)
            reflectiveQuadTo(10f, 14f)
            reflectiveQuadToRelative(0.59f, -1.41f)
            reflectiveQuadTo(12f, 12f)
            reflectiveQuadToRelative(1.41f, 0.59f)
            quadTo(14f, 13.18f, 14f, 14f)
            reflectiveQuadToRelative(-0.59f, 1.41f)
            reflectiveQuadTo(12f, 16f)
            close()
            moveTo(7.38f, 7f)
            horizontalLineToRelative(9.25f)
            lineToRelative(2f, -4f)
            horizontalLineTo(5.38f)
            lineToRelative(2f, 4f)
            close()
            moveTo(8.4f, 21f)
            horizontalLineToRelative(7.2f)
            quadToRelative(2.25f, 0f, 3.82f, -1.56f)
            reflectiveQuadTo(21f, 15.6f)
            quadToRelative(0f, -0.95f, -0.32f, -1.85f)
            reflectiveQuadTo(19.75f, 12.13f)
            lineTo(17.15f, 9f)
            horizontalLineTo(6.85f)
            lineToRelative(-2.6f, 3.13f)
            quadToRelative(-0.6f, 0.72f, -0.92f, 1.63f)
            reflectiveQuadTo(3f, 15.6f)
            quadToRelative(0f, 2.28f, 1.56f, 3.84f)
            reflectiveQuadTo(8.4f, 21f)
            close()
          }
        }
        .build()
    return _MoneyBagFill!!
  }

private var _MoneyBagFill: ImageVector? = null
